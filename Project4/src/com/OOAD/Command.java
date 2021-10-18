package com.OOAD;

public interface Command{
    public void execute(Demonstrator demonstrator);
}

class DemonstratorOnCommand implements Command{
    Demonstrator demonstrator;

    public DemonstratorOnCommand(){
        
    }

     public void execute(Demonstrator demonstrator) {
        demonstrator.demonstrate();
    }

}

class RecommendOnCommand implements Command{
    Demonstrator demonstrator;
    public RecommendOnCommand(){
        
    }

    public void execute(Demonstrator demonstrator) {
        demonstrator.recommend();
    }
}

class ExplainOnCommand implements Command{
    Demonstrator demonstrator;
    public ExplainOnCommand(){
    }

    public void execute(Demonstrator demonstrator){
        demonstrator.explain();
    }
}


