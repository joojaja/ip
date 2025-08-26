public abstract class Task {
    private final String description;
    private boolean isDone;

    public Task(String desc) {
        this.description = desc;
        this.isDone = false; // default false
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markNotDone() {
        this.isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    public String getDescription() {
        return this.description;
    }

    public abstract String toFileString();


    public abstract String getTypeIcon();

    @Override
    public String toString() {
        return getStatusIcon() + " " + this.description;
    }
}
