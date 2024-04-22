public class BulkString {
    public static String getRespValue(String pureValue) {
        String respValue;
        if (pureValue == null) {
            respValue = "$-1" + Constants.CRLF_TERMINATOR;
        } else {
            respValue = "$" + pureValue.length() + Constants.CRLF_TERMINATOR + pureValue +
                    Constants.CRLF_TERMINATOR;
        }
        return respValue;
    }
}
