define(["ember"], function (Ember) {
	var IndexRoute = Ember.Route.extend({
		redirect: function () {
			this.transitionTo('posts');
		}

	});
	return IndexRoute;
});