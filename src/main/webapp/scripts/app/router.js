define([ "ember" ], function(Ember) {
	var Router = Ember.Router.extend({
		root : Ember.Route.extend({
			index : Ember.Route.extend({
				route : '/',
//				selectCategory : Ember.Route.transitionTo('selectCategory'),
				showVolumeInfo : Ember.Route.transitionTo('volumeInfo'),
				connectOutlets : function(router, context) {
					router.get('applicationController').connectOutlet({
						name : 'volumeList',
						context : BooksApp.Volume.find(),
						outletName : 'center'
					});
					router.get('applicationController').connectOutlet({
						name : 'categoryList',
						context : BooksApp.Category.find(),
						outletName : 'left'
					});
				}
			}),
			volumeInfo : Ember.Route.extend({
				route : '/volumeInfo/:volumeInfoId',
				showAllBooks : Ember.Route.transitionTo('index'),
				showDetails : Ember.Route.transitionTo('details'),
				connectOutlets : function(router, context) {
					router.get('applicationController').connectOutlet({
						name : 'volumeInfoDetail',
						context : context,
						outletName : 'center'
					});
				},
				serialize : function(router, context) {
					return {
						volumeInfoId : context.get('id')
					};
				},
				deserialize : function(router, urlParams) {
					return BooksApp.VolumeInfo.find(urlParams.volumeInfoId);
				}
			// // child states
			// initialState : 'details',
			// details : Ember.Route.extend({
			// route : '/',
			// connectOutlets : function(router) {
			// var id = router.get('volumeInfoDetailController.content').id;
			//
			// }
			// })
			})
//			,
//			selectCategory : Ember.Route.extend({
//				route : '/',
//				connectOutlets : function(router, context) {
//					router.get('applicationController').connectOutlet({
//						name : 'categoryList',
//						context : BooksApp.Category.find({ parentId: context }),
//						outletName : 'left'
//					});
//				},
//				serialize : function(router, context) {
//					return {
//						categoryId : context
//					};
//				},
//				deserialize : function(router, urlParams) {
//					return BooksApp.Category.find(urlParams.categoryId);
//				}
//			})
		})

	});

	return Router;
});
