package uni.makarov.hw6;

public class Main {

    public static void main(String[] args) {
        // Create ConcreteComponent and two Decorators
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        // Link decorators
        d1.SetComponent(c);
        d2.SetComponent(d1);

        d2.Operation();
    }

    abstract class Component
    {
        public abstract void Operation();
    }

    class ConcreteComponent extends Component
    {
        @Override
        public  void Operation()
        {
            System.out.println("ConcreteComponent.Operation()");
        }
    }

    // "Decorator"
    abstract class Decorator extends Component
    {
        protected Component component;

        public void SetComponent(Component component)
        {
            this.component = component;
        }
        @Override
        public void Operation()
        {
            if (component != null)
            {
                component.Operation();
            }
        }
    }

    // "ConcreteDecoratorA"
    class ConcreteDecoratorA extends Decorator
    {
        private String addedState;

        @Override
        public void Operation()
        {
            super.Operation();
            addedState = "New State";
            System.out.println("ConcreteDecoratorA.Operation()");
        }
    }

    // "ConcreteDecoratorB"
    class ConcreteDecoratorB extends Decorator
    {
        @Override
        public void Operation()
        {
            super.Operation();
            AddedBehavior();
            System.out.println("ConcreteDecoratorB.Operation()");
        }
        void AddedBehavior()
        { }
    }
}


}




