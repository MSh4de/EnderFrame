package eu.mshade.enderframe.wrapper

abstract class ContextualWrapper<I, O, C>: Mapper<I, O> {

    private val outputByInput: MutableMap<C, MutableMap<I, O>> = mutableMapOf()
    private val inputByOutput: MutableMap<C, MutableMap<O, I>> = mutableMapOf()

    fun map(context: C, input: I): O? = outputByInput[context]?.get(input)

    fun reverseMap(context: C, output: O): I? = inputByOutput[context]?.get(output)

    fun registerMapping(context: C, input: I, output: O) {
        outputByInput.computeIfAbsent(context) { mutableMapOf() }[input] = output
    }

    fun registerReverseMapping(context: C, input: I, output: O) {
        inputByOutput.computeIfAbsent(context) { mutableMapOf() }[output] = input
    }

    fun removeMapping(context: C, input: I) {
        outputByInput[context]?.remove(input)
    }

    fun removeReverseMapping(context: C, output: O) {
        inputByOutput[context]?.remove(output)
    }

}