package com.walla.rover.api.model;

import org.junit.Assert;
import org.junit.Test;


public class BoundsTest {

	@Test
    public void createBounds_Test() {
        final Bounds bounds = Bounds.of(0, 5, 0, 10);

        Assert.assertEquals(0, bounds.getMinX());
        Assert.assertEquals(5, bounds.getMaxX());
        Assert.assertEquals(0, bounds.getMinY());
        Assert.assertEquals(10, bounds.getMaxY());
    }

    @Test
    public void createBoundsToString_Test() {
        final Bounds bounds = Bounds.of(0, 5, 0, 5);
        Assert.assertEquals("[minX=0, maxX=5, minY=0, maxY=5]", bounds.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsIllegalArgumentExceptionToX() {
        Bounds.of(1, 0, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowsIllegalArgumentExceptionToY() {
        Bounds.of(2, 2, 1, 0);
    }

    @Test
    public void shouldEquals() {
        final Bounds bounds1 = Bounds.of(0, 0, 0, 0);
        final Bounds bounds2 = Bounds.of(0, 0, 0, 0);

        Assert.assertEquals(bounds1, bounds2);
        Assert.assertEquals(bounds1.hashCode(), bounds2.hashCode());
    }
    
    // TODO: Not equal
}
