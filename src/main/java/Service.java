import javax.inject.Inject;

public class Service {

    @Inject
    String s;

    @Inject
    public Service(){

    }

    @Inject
    public Service(String s){
        this.s = s;
    }
}
