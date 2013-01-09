define([
  "ember","models/VolumeInfoModel"
],  function(Ember,volumeInfoModel){
	var Router = Ember.Router.extend({
	  root: Ember.Route.extend({
	    index: Ember.Route.extend({
	      route: '/',
	      connectOutlets : function(router) {
	          return router.get('applicationController').connectOutlet('volumeInfoList',volumeInfoModel.create().find());
	        }
	    })
	  })
	});

	return Router;
});
