package io.github.xxori.ggutil.hooks;

public interface ggutilHook {

    boolean isEnabled();

    String getName();

    void disable();
}
