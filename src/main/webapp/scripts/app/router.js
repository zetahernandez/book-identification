define([ "ember" ], function(Ember) {
	var Router = Ember.Router.extend({
		root : Ember.Route.extend({
			index : Ember.Route.extend({
				route : '/',
				search : Ember.Route.transitionTo('searchVolume'),
				showVolumeInfo : Ember.Route.transitionTo('volumeInfo'),
				connectOutlets : function(router, context) {
					router.get('volumeListController').resetLoadMore();
//					var query = { page: 1};
//					router.set('volumeListController.query', query);
//			        router.set('volumeListController.isLoading', true);
					router.get('applicationController').connectOutlet({
						name : 'header',
						context : context,
						outletName : 'header'
					});
					router.get('applicationController').connectOutlet({
						name : 'volumeList',
						outletName : 'center'
					});
					router.get('applicationController').connectOutlet({
						name : 'categoryList',
						context : BooksApp.Category.find(),
						outletName : 'left'
					});
				}
 			}),
     		  loadMoreVolumes: function(router, page) {
    			  router.set('volumeListController.isLoading', true);
		        var query = router.get('volumeListController.query');
		        query.page = page;
		        BooksApp.router.set('loadMoreController.content',BooksApp.store.findQuery(BooksApp.Volume, query));
		      },
		})

	});

	return Router;
});
