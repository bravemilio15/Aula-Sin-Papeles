package vista.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Bravo
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "dd/MM/yyyy"; // Formato Dia/Mes/Año
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value instanceof Calendar) {
            Calendar calendar = (Calendar) value;
            return dateFormatter.format(calendar.getTime());
        }
        return "";  
    }
}
