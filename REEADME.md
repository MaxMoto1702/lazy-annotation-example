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
