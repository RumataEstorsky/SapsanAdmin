package sapsan.schema;

/**
 * Этот файл является частью программы "demo".
 * Любое распространение без письменного  разрешения автора запрещено!
 * <p/>
 * Автор: Румата Эсторский <rumata@sputnikchess.ru>
 * Создан: 30.08.13 в 15:23
 */
public enum DataType {
    /** Signed Ints */
    Int8, Int16, Int32, Int64,
    /** Floats (IEEE 754) */
    Float32, Float64,
    Char, String, Boolean,

    /** Любые другие типы */
    Other
}
