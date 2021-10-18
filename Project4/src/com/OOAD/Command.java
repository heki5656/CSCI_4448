package com.OOAD;

public interface Command{
    public void execute();
}

class DemonstratorOnCommand implements Command{
    Demonstrator demonstrator;

    public DemonstratorOnCommand(Demonstrator demonstrator){
        this.demonstrator = demonstrator;
    }


     public void execute(Demonstrator demonstrator) {
        demonstrator.demonstrate();
    }

}

class RecommendOnCommand implements Command{
    public RecommendOnCommand(Demonstrator demonstrator){
        this.demonstrator = demonstrator;
    }

    public void execute(Demonstrator demonstrator) {
        demonstrator.recommend();
    }
}

class ExplainOnCommand implements Command{
    public ExplainOnCommand(Demonstrator demonstrator){
        this.demonstrator = demonstrator;
    }

    public void execute(Demonstrator demonstrator){
        demonstrator.explain();
    }
}


