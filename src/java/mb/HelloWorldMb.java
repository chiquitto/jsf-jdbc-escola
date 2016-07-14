package mb;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloWorldMb")
public class HelloWorldMb {
    public String getNome() {
        return "Jean Claude Van Dame Da Silva";
    }
}
