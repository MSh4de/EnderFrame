package eu.mshade.enderframe.wrapper;

import java.util.HashMap;
import java.util.Map;

public abstract class Wrapper<I, O> {

    protected Map<I, O> outputByInput = new HashMap<>();
    protected Map<O, I> inputByOutput = new HashMap<>();

    public O wrap(I input) {
        return this.outputByInput.get(input);
    }

    public I reverse(O output) {
        return this.inputByOutput.get(output);
    }

    public void register(I i, O o) {
        this.inputByOutput.put(o, i);
        this.outputByInput.put(i, o);
    }

    public void registerInput(I i, O o) {
        this.outputByInput.put(i, o);
    }

    public void registerOutput(O o, I i) {
        this.inputByOutput.put(o, i);
    }

    public boolean isSupport(I i) {
        return this.outputByInput.containsKey(i);
    }

}
