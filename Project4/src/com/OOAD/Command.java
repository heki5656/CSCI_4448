package com.OOAD;

public interface Command{
    public void execute(Demonstrator demonstrator);
}

class DemonstratorOnCommand implements Command{

     public void execute(Demonstrator demonstrator) {
         demonstrator.demonstrate();
    }
}

class RecommendOnCommand implements Command{
    public void execute(Demonstrator demonstrator) {

        demonstrator.recommend();
    }
}

class ExplainOnCommand implements Command{
    public void execute(Demonstrator demonstrator){
        demonstrator.explain();
    }
}


