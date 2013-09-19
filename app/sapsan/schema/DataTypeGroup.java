package sapsan.schema;

/**
 * Этот файл является частью программы "demo".
 * Любое распространение без письменного  разрешения автора запрещено!
 * <p/>
 * Автор: Румата Эсторский <rumata@sputnikchess.ru>
 * Создан: 09.08.13 в 14:15
 */
public enum DataTypeGroup {
    /**
     * Булев тип
     */
    Boolean,
    /**
     * Byte, Short, Integer, Int (Scala), Long,
     */
    Integer,
    /**
     * Float, Double
     */
    Float,
    /**
     * String, StringBuffer, StringBuilder, CharSequence
     */
    String, Password,
    Text, CKEditor, CodeMirror, Wysihtml5,
    Email,
    /**
     * Date, Time
     */
    Timestamp,
    /**
     * byte[], ByteBuffer
     */
    Blob,
    Enumerated, /** Set, */
    /**
     * Разные поля
     */
    Hidden,
    Lists,
    FileUpload,
    /**
     * Связочные поля
     */
    OneToOne, OneToMany, ManyToOne, ManyToMany,
    /**
     * Ключевые поля
     */
    Primary,

    /** Jelly: Expression, Image, Slug, Polymorphic */



}
