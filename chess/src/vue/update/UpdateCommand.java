package vue.update;

import vue.ChessGameGUI;

public interface UpdateCommand {

	public void execute(ChessGameGUI gui);
	
}
