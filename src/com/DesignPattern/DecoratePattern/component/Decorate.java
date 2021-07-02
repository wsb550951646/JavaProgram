package com.DesignPattern.DecoratePattern.component;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/816:14
 */
public abstract class Decorate extends Component {

    public Component component;

    public Decorate(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
