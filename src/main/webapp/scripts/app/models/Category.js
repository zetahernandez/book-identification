define([ "require", "ember", "ember_data"], function(require, Ember) {
	var Category = DS.Model.extend({
		id : DS.attr('number'),
		category : DS.attr('string'),
		parentId : DS.attr('number'),
		subCategories: DS.hasMany('BooksApp.Category')
	});
	return Category;
});