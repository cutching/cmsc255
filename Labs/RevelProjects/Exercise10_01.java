package Labs.RevelProjects;

public class Exercise10_01
{
    public static void main(String[] args)
    {
        Time clock1 = new Time();
        Time clock2 = new Time(555550000);
        Time clock3 = new Time(5,23,55);
        System.out.println(clock1.getHour() + ":" + clock1.getMinute() + ":" + clock1.getSecond());
        System.out.println(clock2.getHour() + ":" + clock2.getMinute() + ":" + clock2.getSecond());
        System.out.println(clock3.getHour() + ":" + clock3.getMinute() + ":" + clock3.getSecond());
    }
    static class Time
    {
        private long totalMilliseconds = System.currentTimeMillis();

        private long totalSecond = totalMilliseconds / 1000;
        private long second = totalSecond % 60;

        private long totalMinute = totalSecond / 60;
        private long minute = totalMinute % 60;

        private long totalHour = totalMinute / 60;
        private long hour = totalHour % 24;



        public Time(){
            hour = hour -4;
        }

        public Time(long elapsed)
        {
            totalMilliseconds = elapsed;
            totalSecond = totalMilliseconds / 1000;
            second = totalSecond % 60;

            totalMinute = totalSecond / 60;
            minute = totalMinute % 60;

            totalHour = totalMinute / 60;
            hour = totalHour % 24;
        }

        public Time(long hour, long minute, long second)
        {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public void setTime(long elapsedTime)
        {
            totalSecond = elapsedTime;
            totalMinute = totalSecond / 60;
            totalHour = totalMinute / 60;
            hour = totalHour % 24;
            minute = totalMinute % 60;
            second = totalSecond % 60;
        }

        public long getHour() {
            return hour;
        }

        public long getMinute() {
            return minute;
        }

        public long getSecond() {
            return second;
        }

        public void setHour(long hour) {
            this.hour = hour;
        }

        public void setMinute(long minute) {
            this.minute = minute;
        }

        public void setSecond(long second) {
            this.second = second;
        }
    }
}


