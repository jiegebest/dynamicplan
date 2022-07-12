package designpattern;

public abstract class Handler {
	private Handler next;

	public final void handle(int level) {
		if (this.getLevel() == level) {
			this.echo();
		} else {
			if (this.next != null) {
				this.next.handle(level);
			}
		}
	}

	public final void setNext(Handler next) {
		this.next = next;
	}

	protected abstract int getLevel();

	protected abstract void echo();
}
