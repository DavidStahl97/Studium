package application.controller;

import application.models.PictureList;
import application.views.PictureListView;

public class PictureListController {
	
	private PictureListView view;
	private PictureList model;
	
	public PictureListController(PictureListView view, PictureList model)
	{
		this.view = view;
		this.model = model;
	}
	
}
