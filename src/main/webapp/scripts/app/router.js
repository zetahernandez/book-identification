define([
  "ember","models/Volume"
],  function(Ember,volumeModel){
	var Router = Ember.Router.extend({
	  root: Ember.Route.extend({
	    index: Ember.Route.extend({
	      route: '/',
	      connectOutlets : function(router) {
	          return router.get('applicationController').connectOutlet('volumeInfoList',BooksApp.Volume.find());
//	          return router.get('applicationController').connectOutlet('volumeInfoList',volumeModel.find());
	        }
	    })
	  })
	});

	return Router;
});
