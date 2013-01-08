define([
  "ember",
  "controllers/VolumeInfoListController"
],  function(Ember,volumeInfoListController){
	var Router = Ember.Router.extend({
	  root: Ember.Route.extend({
	    index: Ember.Route.extend({
	      route: '/',
	      connectOutlets : function(router, context) {
	    	  volumeInfoListController.showAll();
	          return router.get('applicationController').connectOutlet('volumes');
	        }
	    })
	  })
	});

	return Router;
});
