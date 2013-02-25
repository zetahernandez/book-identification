define(["ember"], function (Ember) {
	var Router = function () {
		this.resource('categories');
		this.resource('category');
		this.resource('volumes');
		this.resource('volume', {
			path: '/volumes/:person_id'
		});
		this.route('edit_volume', {
			path: '/people/:person_id/edit'
		});
		this.route('new_person', {
			path: '/people/new'
		});
	};
	return Router;
});