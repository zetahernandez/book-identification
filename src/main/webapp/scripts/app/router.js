define([ "ember", "controllers/VolumeListController" ], function(Ember,
		volumeListController) {
	var Router = Ember.Router.extend({
		root : Ember.Route.extend({
			index : Ember.Route.extend({
				route : '/',
				showVolumeInfo : Ember.Route.transitionTo('volumeInfo'),
				connectOutlets : function(router) {
					return router.get('applicationController').connectOutlet(
							'volumeList', BooksApp.Volume.find());
				}
			}),
			showVolumeInfo : Ember.Route.extend({
				route : '/:volumeInfoId',
				showAllBooks : Ember.Route.transitionTo('index'),
				showDetails : Ember.Route.transitionTo('details'),
				connectOutlets : function(router, context) {
					router.get('applicationController').connectOutlet(
							'oneContributor', context);
				},
				serialize : function(router, context) {
					return {
						githubUserName : context.get('login')
					};
				},
				deserialize : function(router, urlParams) {
					return App.Contributor.findOne(urlParams.githubUserName);
				},
				// child states
				initialState : 'details',
						
			})
		})

	});

	return Router;
});
