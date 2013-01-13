define([ "ember" ], function(Ember) {
	var Router = Ember.Router.extend({
		root : Ember.Route.extend({
			index : Ember.Route.extend({
				route : '/',
				showVolumeInfo : Ember.Route.transitionTo('volumeInfo'),
				connectOutlets : function(router, context) {
					router.get('applicationController').connectOutlet({
						name : 'volumeList',
						context : BooksApp.Volume.find(),
						outletName : 'center'
					});
					router.get('applicationController').connectOutlet({
						name : 'categoryList',
						context:  BooksApp.Category.find(),
						outletName : 'left'
					});
				}
			}),
			volumeInfo : Ember.Route.extend({
				route : '/:context',
				showAllBooks : Ember.Route.transitionTo('index'),
				showDetails : Ember.Route.transitionTo('details'),
				connectOutlets : function(router, context) {
					router.get('applicationController').connectOutlet({
							name : 'volumeInfoDetail',
							context:  context,
							outletName : 'center'
					});
				}
//				// child states
//				initialState : 'details',
//				details : Ember.Route.extend({
//					route : '/',
//					connectOutlets : function(router) {
//						var id = router.get('volumeInfoDetailController.content').id;
//
//					}
//				})

			})
		})

	});

	return Router;
});
