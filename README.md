OwnEventBus Implement
=====================

This Demo project just finish the core EventBus code, it will help you to know the EventBus theory.I hope it will help you.

# 原理

Event Bus 实际上是监听者模式。如果你在某个组建内需要收到事件通知，那么你需要将这个组建注册到EventBus中去，当有事件产生时EventBus会依次将事件分发给注册了监听的组建（通过反射或注解等方式实现），最后当组建不需要监听事件的时候你需要取消注册避免不必要的开销。
具体实现请看源码。
