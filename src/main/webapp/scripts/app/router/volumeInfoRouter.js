define([ "ember" ], function(Ember) {
	var volumeInfo = Ember.Route.extend({
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
		},
		voumeInfo : require('router/volumeInfoRouter')
	// // child states
	// initialState : 'details',
	// details : Ember.Route.extend({
	// route : '/',
	// connectOutlets : function(router) {
	// var id = router.get('volumeInfoDetailController.content').id;
	//
	// }
	// })

	});
	return volumeInfo;
});