define(["ember"], function (Ember) {
	var Router = Ember.Router.map(function () {
			this.resource('people');
			this.resource('person', {path: '/people/:person_id'});
			this.route('edit_person', {path: '/people/:person_id/edit'});
			this.route('new_person', {path: '/people/new'});
		});
	return Router;
});