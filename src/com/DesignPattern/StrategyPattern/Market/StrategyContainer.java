package com.DesignPattern.StrategyPattern.Market;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/89:55
 */
public class StrategyContainer {

    private IStrategy iStrategy;

    public StrategyContainer(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public StrategyContainer() {
    }

    public IStrategy getiStrategy() {
        return iStrategy;
    }

    public void setiStrategy(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void operation(){
        iStrategy.strategy();
    }
}
