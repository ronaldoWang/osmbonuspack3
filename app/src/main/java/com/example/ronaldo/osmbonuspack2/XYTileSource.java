package com.example.ronaldo.osmbonuspack2;

import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;

/**
 * An implementation of {@link org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase}
 */
public class XYTileSource extends OnlineTileSourceBase {

    public XYTileSource(final String aName, final int aZoomMinLevel,
                        final int aZoomMaxLevel, final int aTileSizePixels, final String aImageFilenameEnding,
                        final String[] aBaseUrl) {
        super(aName, aZoomMinLevel, aZoomMaxLevel, aTileSizePixels,
                aImageFilenameEnding, aBaseUrl);
    }

    @Override
    public String getTileURLString(final MapTile aTile) {
//		return getBaseUrl() + aTile.getZoomLevel() + "/" + aTile.getX() + "/" + aTile.getY()
//				+ mImageFilenameEnding;
        System.out.print(getBaseUrl() + "&zoom=" + aTile.getZoomLevel() + "&x=" + aTile.getX() + "&y=" + aTile.getY());
        return getBaseUrl() + "&zoom=" + aTile.getZoomLevel() + "&x=" + aTile.getX() + "&y=" + aTile.getY();
    }
}
