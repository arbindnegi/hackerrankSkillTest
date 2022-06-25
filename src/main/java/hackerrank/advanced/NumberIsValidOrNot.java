/**
 * 
 */
package hackerrank.advanced;

/**
 * @author Arbind Negi 16-Jun-2022
 *
 */
public class NumberIsValidOrNot {

    public static void main(String[] args) {
	String number = "4.0";
	System.out.println(isNumberValid(number));

    }

    static boolean isNumberValid(String s) {
	if (s.isEmpty()) {
	    return true;
	}
	int i = 0;
	if (s.charAt(i) == '+' || s.charAt(i) == '-') {
	    ++i;
	}

	STATE current_state = STATE.START;

	while (i < s.length()) {
	    current_state = get_next_state(current_state, s.charAt(i));

	    if (current_state == STATE.UNKNOWN) {
		return false;
	    }
	    i = i + 1;
	}

	// If the last digit is Decimal than it will return false
	if (current_state == STATE.DECIMAL)
	    return false;

	return true;
    }
    
    enum STATE {
	START, INTEGER, DECIMAL, UNKNOWN, AFTER_DECIMAL
    };

    static STATE get_next_state(STATE current_state, char ch) {
	switch (current_state) {
	case START:
	case INTEGER:
	    if (ch == '.') {
		return STATE.DECIMAL;
	    } else if (ch >= '0' && ch <= '9') {
		return STATE.INTEGER;
	    } else {
		return STATE.UNKNOWN;
	    }
	case DECIMAL:
	    if (ch >= '0' && ch <= '9') {
		return STATE.AFTER_DECIMAL;
	    } else {
		return STATE.UNKNOWN;
	    }
	case AFTER_DECIMAL:
	    if (ch >= '0' && ch <= '9') {
		return STATE.AFTER_DECIMAL;
	    } else {
		return STATE.UNKNOWN;
	    }
	}
	return STATE.UNKNOWN;
    }
}
