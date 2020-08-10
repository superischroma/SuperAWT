package me.superischroma.superawt;

public abstract class KeyPressResult
{
    private final int key;

    public KeyPressResult(int key)
    {
        this.key = key;
    }

    public int getKey()
    {
        return key;
    }

    public abstract void run();
}