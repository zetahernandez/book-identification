define([
	"views/ApplicationView",
	"views/VolumesView",
	"controllers/ApplicationController",
	"app/router"
], function(ApplicationView, ApplicationController, VolumesView, Router){
	/*Module Pattern*/
	var App = Ember.Mixin.create({
		ApplicationView: ApplicationView,
		ApplicationController: ApplicationController,
		VolumesView: VolumesView,
		Router: Router
	});

	return App;
});
