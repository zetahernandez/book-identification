(function(root){
	require(["config"], function(config){
		requirejs.config(config);
		require(["App", "domReady!", "ember","ember_data","endless"], function(App, doc, Ember,DS,endless){
			var app_name = config.app_name || "App";
			root[app_name] = App = Ember.Application.create(App);
			!App.isInitialized && App.initialize();
		});
	});
})(this);

