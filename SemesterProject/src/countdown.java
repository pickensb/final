import com.apple.eawt.Application;

public class countdown extends userInput {
	    private static final int SECONDS_PER_DAY = 86_400;
	    private static final int SECONDS_PER_HOUR = 3600;
	    private static final int SECONDS_PER_MINUTE = 60;
	    private Tile days;
	    private Tile hours;
	    private Tile minutes;
	    private Tile seconds;
	    private Duration duration;
	    private long lastTimerCall;
	    private AnimationTimer timer;


	    public void init() {
	        days = createTile("DAYS", "0");
	        hours = createTile("HOURS", "0");
	        minutes = createTile("MINUTES", "0");
	        seconds = createTile("SECONDS", "0");

	        duration = Duration.hours(72);

	        lastTimerCall = System.nanoTime();
	        
	        timer = new AnimationTimer() {
	        	
	        public void handle(final long now) {
	                if (now > lastTimerCall + 1_000_000_000l) {
	                    duration = duration.subtract(Duration.seconds(1));

	                    int remainingSeconds = (int) duration.toSeconds();
	                    int d = remainingSeconds / SECONDS_PER_DAY;
	                    int h = (remainingSeconds % SECONDS_PER_DAY) / SECONDS_PER_HOUR;
	                    int m = ((remainingSeconds % SECONDS_PER_DAY) % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
	                    int s = (((remainingSeconds % SECONDS_PER_DAY) % SECONDS_PER_HOUR) % SECONDS_PER_MINUTE);

	                    if (d == 0 && h == 0 && m == 0 && s == 0) { timer.stop(); }

	                    days.setDescription(Integer.toString(d));
	                    hours.setDescription(Integer.toString(h));
	                    minutes.setDescription(String.format("%02d", m));
	                    seconds.setDescription(String.format("%02d", s));

	                    lastTimerCall = now;
	                }
	            }
	        };
	    }

	   public void start(Stage stage) {

	        HBox pane = new HBox(20, days, hours, minutes, seconds);
	        pane.setPadding(new Insets(10));
	        pane.setBackground(new Background(new BackgroundFill(Color.web("#606060"), CornerRadii.EMPTY, Insets.EMPTY)));

	        Scene scene = new Scene(pane);

	        stage.setTitle("Countdown");
	        stage.setScene(scene);
	        stage.show();

	        timer.start();
	    }

	   public void stop() {
	        System.exit(0);
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	    private Tile createTile(final String TITLE, final String TEXT) {
	        return TileBuilder.create().skinType(SkinType.CHARACTER)
	                          .prefSize(200, 200)
	                          .title(TITLE)
	                          .titleAlignment(TextAlignment.CENTER)
	                          .description(TEXT)
	                          .build();
	    }

}
