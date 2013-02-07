define(["views/ApplicationView", "views/HeaderView", "views/VolumeListView", "views/CategoryListView", "views/VolumeInfoView", "views/VolumeInfoDetailView", "views/NavigationView", "views/SearchVolumeView", "views/LoadMoreView", "controllers/ApplicationController", "controllers/HeaderController", "controllers/VolumeListController", "controllers/CategoryListController", "controllers/VolumeInfoDetailController", "controllers/SearchVolumeController", "controllers/LoadMoreController", "models/Volume", "models/VolumeInfo", "models/Category", "models/ImageLink", "models/IndustryIdentifier", "app/router", "ember_data"],

function (ApplicationView, HeaderView, VolumeListView, CategoryListView, VolumeInfoView, VolumeInfoDetailView, NavigationView, SearchVolumeView, LoadMoreView, ApplicationController, HeaderController, VolumeListController, CategoryListController, VolumeInfoDetailController, SearchVolumeController, LoadMoreController, Volume, VolumeInfo, Category, ImageLink, IndustryIdentifier, Router) { /* Module Pattern */
	var App = Ember.Mixin.create({
		ApplicationView: ApplicationView,
		HeaderView: HeaderView,
		VolumeListView: VolumeListView,
		CategoryListView: CategoryListView,
		VolumeInfoView: VolumeInfoView,
		VolumeInfoDetailView: VolumeInfoDetailView,
		NavigationView: NavigationView,
		SearchVolumeView: SearchVolumeView,
		LoadMoreView: LoadMoreView,
		ApplicationController: ApplicationController,
		HeaderController: HeaderController,
		VolumeListController: VolumeListController,
		CategoryListController: CategoryListController,
		VolumeInfoDetailController: VolumeInfoDetailController,
		SearchVolumeController: SearchVolumeController,
		LoadMoreController: LoadMoreController,
		Router: Router,
		Volume: Volume,
		VolumeInfo: VolumeInfo,
		Category: Category,
		ImageLink: ImageLink,
		IndustryIdentifier: IndustryIdentifier,
		store: DS.Store.create({
			revision: 4,
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
		}),
		ready: function () {}

	});
	return App;
});