import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Lost {
    private Calendar time; //失物时间
    private String name; //失物名称

    public Lost(Calendar time, String name) {
        this.time = time;
        this.name = name;
    }

    public Calendar getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");

        return "time=" + sdf.format(time.getTime()) +
                ", name='" + name + '\'';
    }
}

