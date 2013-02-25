define(["views/IndexView", "views/HeaderView", "views/VolumeListView", "views/CategoryListView", "views/VolumeInfoView", "views/VolumeInfoDetailView", "views/NavigationView", "views/SearchVolumeView", "views/LoadMoreView", "controllers/IndexController", "controllers/HeaderController", "controllers/VolumeListController", "controllers/CategoryListController", "controllers/VolumeInfoDetailController", "controllers/SearchVolumeController", "controllers/LoadMoreController", "models/Volume", "models/VolumeInfo", "models/Category", "models/ImageLink", "models/IndustryIdentifier", "app/router", "routes/IndexRoute"],

function (IndexView, HeaderView, VolumeListView, CategoryListView, VolumeInfoView, VolumeInfoDetailView, NavigationView, SearchVolumeView, LoadMoreView, IndexController, HeaderController, VolumeListController, CategoryListController, VolumeInfoDetailController, SearchVolumeController, LoadMoreController, Volume, VolumeInfo, Category, ImageLink, IndustryIdentifier, Router, IndexRoute) { /* Module Pattern */
	var App = Ember.Application.create();
	App.IndexView = IndexView;
	App.HeaderView = HeaderView;
	App.VolumeListView = VolumeListView;
	App.CategoryListView = CategoryListView;
	App.VolumeInfoView = VolumeInfoView;
	App.VolumeInfoDetailView = VolumeInfoDetailView;
	App.NavigationView = NavigationView;
	App.SearchVolumeView = SearchVolumeView;
	App.LoadMoreView = LoadMoreView;
	App.IndexController = IndexController;
	App.HeaderController = HeaderController;
	App.VolumeListController = VolumeListController;
	App.CategoryListController = CategoryListController;
	App.VolumeInfoDetailController = VolumeInfoDetailController;
	App.SearchVolumeController = SearchVolumeController;
	App.LoadMoreController = LoadMoreController;
	App.Router.map(Router);
	App.Volume = Volume;
	App.VolumeInfo = VolumeInfo;
	App.Category = Category;
	App.ImageLink = ImageLink;
	App.IndustryIdentifier = IndustryIdentifier;
	App.IndexRoute = IndexRoute;
	App.store = DS.Store.create({
		revision: 11,
		adapter: DS.RESTAdapter.create({
			bulkCommit: false,
			mappings: {
				volume: Volume,
				volume_info: VolumeInfo,
				category: Category,
				image_links: ImageLink,
				industry_identifier: IndustryIdentifier
			},
			plurals: {
				volume: 'volumes',
				volume_info: 'volumesInfo',
				category: 'categories',
				industry_identifier: 'industryIdentifiers',
				image_link: 'imageLinks'

			},
			namespace: 'rest' // you should change the first
			// segment
			// according to the application's folder
			// path on the server.
		})

	});
	return App;
});