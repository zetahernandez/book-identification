define([
	"views/ApplicationView",
	"views/VolumeInfoListView",
	"views/VolumeInfoView",
	"controllers/ApplicationController",
	"controllers/VolumeInfoListController",
	"app/router"
], function(ApplicationView,VolumeInfoListView,VolumeInfoView,ApplicationController,VolumeInfoListController,Router){
	/*Module Pattern*/
	var App = Ember.Mixin.create({
		ApplicationView: ApplicationView,
		VolumeInfoListView: VolumeInfoListView,
		VolumeInfoView: VolumeInfoView,
		ApplicationController: ApplicationController,
		VolumeInfoListController: VolumeInfoListController,
		Router: Router
	});

	return App;
});
