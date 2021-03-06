package com.jcloisterzone.action;

import java.awt.Image;
import java.util.Set;

import com.jcloisterzone.board.Position;
import com.jcloisterzone.rmi.Client2ClientIF;
import com.jcloisterzone.ui.grid.GridLayer;
import com.jcloisterzone.ui.grid.layer.TileActionLayer;


public class TowerPieceAction extends SelectTileAction {

	public TowerPieceAction() {
		super();
	}

	public TowerPieceAction(Set<Position> sites) {
		super(sites);
	}

	@Override
	public void perform(Client2ClientIF server, Position p) {
		server.placeTowerPiece(p);
	}

	@Override
	protected int getSortOrder() {
		return 20;
	}
	
	@Override
	protected GridLayer createGridLayer() {
		Image gd = client.getControlsTheme().getActionDecoration("tower");
		return new TileActionLayer(client.getGridPanel(), this, gd);
	}

}
