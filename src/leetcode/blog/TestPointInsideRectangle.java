package leetcode.blog;

public class TestPointInsideRectangle {
	// Q3 Determine if a point is inside a rectangle/irregular polygon
	// Rectangle ABCD and Point P
	// 1. Calculate the sum of areas of all triangles. ABP, BCP, CDP, DAP.
	// if the sum is larger than the area of the rectangle, P is outside the
	// rectangle
	// if the sum is smaller than the area of the rectangle, P is inside the
	// rectangle
	// if equal, it is on one side line.
	// 2. Calculate the perpendicular distances of P from all the 4 lines
	// 3. Transform the rectangle to be aligned to axis
}
