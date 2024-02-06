# Show using `@Lazy` annotation in construct parameter

```java
public interface FooService { }

public interface BarService { }

@Service
public class FooServiceImpl implements FooService {
    private final BarService barService;
    public FooServiceImpl(BarService barService) {
        this.barService = barService;
    }
}

@Service
public class BarServiceImpl implements BarService {
    private final FooService fooService;
    public BarServiceImpl(@Lazy FooService fooService) {
        this.fooService = fooService;
    }
}
```

If remove `@Lazy` annotation then:
```
***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

   lazyApplication
┌─────┐
|  fooServiceImpl defined in file [/Users/max/Workspace/Sandbox/lazy/build/classes/java/main/com/example/lazy/service/impl/FooServiceImpl.class]
↑     ↓
|  barServiceImpl defined in file [/Users/max/Workspace/Sandbox/lazy/build/classes/java/main/com/example/lazy/service/impl/BarServiceImpl.class]
└─────┘

```
