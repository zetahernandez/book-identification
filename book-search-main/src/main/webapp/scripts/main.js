(function(root){
	require(["config"], function(config){
		requirejs.config(config);
		require(["App", "domReady!", "ember","ember_data","inview","bootstrap"], function(App, doc, Ember,DS,inview,bootsrap){
			var app_name = config.app_name || "App";
			root[app_name] = App;
		});
	});
})(this);

