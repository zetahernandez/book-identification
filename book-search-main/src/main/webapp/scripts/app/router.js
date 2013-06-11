 define(["ember"], function (Ember) {
	var Router = function () {

		this.resource('categories');

		this.resource("volumes", {
			path: "/volumes"
		});
		this.resource("volumeInfoDetail", {
			path: "/volumes/:volume_id"
		});
		this.resource("uploadBooks", {
			path: "/uploadBook"
		});
	};
	return Router;
});