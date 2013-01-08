define([
	"views/ApplicationView",
	"views/VolumesView",
	"controllers/ApplicationController",
	"controllers/VolumeInfoListController",
	"app/router"
], function(ApplicationView,VolumesView,ApplicationController,VolumeInfoListController,Router){
	/*Module Pattern*/
	var App = Ember.Mixin.create({
		ApplicationView: ApplicationView,
		ApplicationController: ApplicationController,
		VolumeInfoListController: VolumeInfoListController,
		VolumesView: VolumesView,
		Router: Router
	});

	return App;
});
