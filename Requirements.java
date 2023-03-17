public interface Requirements {

    /*
     * List of members in the group
     */
    String[] groepsleden();

    /*
     * Convert char to morse code
     */
    String abs2morse(char inputChar);

    /*
     * Convert morse code to char
     */
    char morse2abc(String inputString);

    /*
     * Convert from input field
     */
    void convert();

    /*
     * swap input and output fields data
     */
    void swap();

    /*
     * Clear inout and output data
     */
    void clear();

    /*
     * Example input for morse code to abc
     */
    String exampleMorseCode();

    /*
     * Example input for morse code to abc
     */
    String exampleString();

    /*
     * Help
     */
    String explain();


}