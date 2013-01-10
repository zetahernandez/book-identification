define([ "require", "ember", "ember_data"], function(require, Ember) {
	var Category = DS.Model.extend({
		id : DS.attr('number'),
		category : DS.attr('string'),
		parentId : DS.attr('number')
	});
	return Category;
});